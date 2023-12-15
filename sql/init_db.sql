CREATE TABLE worker (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    birthday DATE,
    level VARCHAR(10) NOT NULL,
    salary INT CHECK (salary >= 100 AND salary <=100000)
);

ALTER TABLE worker
ADD CONSTRAINT level_enum_values
CHECK (level IN('Trainee', 'Junior', 'Middle', 'Senior'));

CREATE TABLE client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL
);

CREATE TABLE project (
    id IDENTITY PRIMARY KEY,
    client_id BIGINT,
    start_date DATE,
    finish_date DATE
);

ALTER TABLE project
ADD CONSTRAINT client_id_fk
FOREIGN KEY(client_id)
REFERENCES client(id);

CREATE TABLE project_worker (
    project_id BIGINT,
    worker_id BIGINT,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY(project_id) REFERENCES project(id),
    FOREIGN KEY (worker_id) REFERENCES worker(id)
);