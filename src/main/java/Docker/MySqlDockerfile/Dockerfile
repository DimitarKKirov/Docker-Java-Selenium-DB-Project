FROM mysql/mysql-server:latest
ENV MYSQL_ROOT_PASSWORD=pass
ENV MYSQL_DATABASE=testdb
ENV MYSQL_PASSWORD=dimitar
ENV MYSQL_USER=dimitar

COPY ./create.sql /docker-entrypoint-initdb.d/create.sql
