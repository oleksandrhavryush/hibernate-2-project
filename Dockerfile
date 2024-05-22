FROM mysql:latest
ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE movie
ADD ./dump-hibernate-2.sql /docker-entrypoint-initdb.d