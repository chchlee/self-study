# docker 설정

## MySQL

```zsh
# 이미지 가져오기
$ docker pull mysql

# 실행
$ docker run - d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1q2w3e4r \
-v $HOME/DockerData/{container-name}:/var/lib/mysql \
--name {container-name} mysql:latest \
--character-set-server=utf8mb4 \
--collaction-server=utf8mb4_unicode_ci

$ docker ps

$ docker exec -it {container-name}  bash
root@12312321321:/# mysql -u root -p
```