FROM postgres:latest
ENV POSTGRES_PASSWORD password
ENV POSTGRES_USER dimitar
ENV POSTGRES_DB testdb
EXPOSE 5432
COPY create.sql /docker-entrypoint-initdb.d/create.sql