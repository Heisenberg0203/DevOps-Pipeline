docker network create --driver bridge --subnet 172.16.192.0/24 --gateway 172.16.192.1 spe-network
	

#---Configure Jenkins Server
docker pull jenkins/jenkins:lts
docker create -it --name jenkins_server -p 8081:8080 -p 50001:50000 -v spe_jenkins_home:/var/jenkins_home jenkins/jenkins:lts
docker network connect --ip 172.16.192.2 spe-network jenkins_server
docker start jenkins_server
docker exec -u root jenkins_server apt-get update
docker exec -u root jenkins_server apt-get install -y maven 

#--Configure Ansible Server
docker create -it --name ansible_server ubuntu:latest
docker network connect --ip 172.16.192.3 spe-network ansible_server
docker start ansible_server
docker exec -u root ansible_server apt-get update
docker exec -u root ansible_server apt-get install -y openssh-server ansible vim sshpass
docker exec -it -u root ansible_server vim  /etc/ssh/sshd_config #Permit Rootlogin yes
#sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/g' /etc/ssh/sshd_config
docker exec -it -u root ansible_server passwd #setup new password
#echo -e "root\nroot" | passwd 
docker exec -it -u root ansible_server ssh-keygen -t rsa
#ssh-keygen -q -t rsa -N '' <<< ""$'\n'"y" 2>&1 >/dev/null
docker exec -it -u root ansible_server ssh-copy-id root@172.16.192.3
#sshpass -f password.txt ssh-copy-id user@yourserver
docker exec -u root ansible_server /etc/init.d/ssh restart


#pull image
docker pull rootushikesh0203/spe_calculator:ansible
docker create -it --name ansible_server ansible:latest
docker network connect --ip 172.16.192.3 spe-network ansible_server
docker start ansible_server
#inside container
docker exec -u root ansible_server /etc/init.d/ssh restart #must
docker exec -it -u root ansible_server ssh-copy-id root@172.16.192.3
docker exec -u root ansible_server /etc/init.d/ssh restart
docker exec -u root ansible_server ansible-playbook -i /ansible-playbook/hosts /ansible-playbook/create-file.yml
#enter hosts in host file

#docker_server



docker create -it -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):$(which docker) --group-add $(stat -c '%g' /var/run/docker.sock) --name docker_server ubuntu bash
apt-get update
apt-get install -y docker openssh-server vim
sed -i 's/#PasswordAuthentication yes/PasswordAuthentication yes/g' /etc/ssh/sshd_config
/etc/init.d/ssh restart
mkdir /opt/docker
chown dockeradmin /opt/docker
mkhomedir_helper dockeradmin

#entrypoint: /etc/init.d/ssh restart






	
