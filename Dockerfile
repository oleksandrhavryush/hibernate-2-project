FROM mysql:5.7
ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE movie
ADD ./dump-hibernate-2.sql /docker-entrypoint-initdb.d