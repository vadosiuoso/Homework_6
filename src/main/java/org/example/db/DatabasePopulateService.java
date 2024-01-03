package org.example.db;


import org.example.dao.ClientDao;
import org.example.dao.ProjectDao;
import org.example.dao.ProjectWorkersDao;
import org.example.dao.WorkerDao;
import org.example.model.Client;
import org.example.model.Project;
import org.example.model.Worker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();

        List<Worker> workerList = new ArrayList<>();
        workerList.add(new Worker("Adam", "1987-12-05", "Senior", 6000));
        workerList.add(new Worker("Anton", "1999-10-08", "Trainee", 800));
        workerList.add(new Worker("John", "1987-12-05", "Middle", 3500));
        workerList.add(new Worker("Thomas", "1980-02-18", "Senior", 5000));
        workerList.add(new Worker("Taras", "1992-01-10", "Junior", 1900));
        workerList.add(new Worker("Alex", "2000-04-19", "Junior", 1700));
        workerList.add(new Worker("James", "1984-09-24", "Middle", 3900));
        workerList.add(new Worker("Igor", "1989-07-11", "Trainee", 1200));
        workerList.add(new Worker("Max", "1977-04-29", "Senior", 5600));
        workerList.add(new Worker("Hans", "1995-12-01", "Junior", 2200));
        WorkerDao workerDao = new WorkerDao(connection);
        for (Worker worker: workerList) {
            workerDao.insertWorker(worker);
        }

        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client("Lisa"));
        clientList.add(new Client("Arseniy"));
        clientList.add(new Client("Konstantin"));
        clientList.add(new Client("Sergii"));
        clientList.add(new Client("Anne"));
        ClientDao clientDao = new ClientDao(connection);
        for (Client client : clientList) {
            clientDao.insertClients(client);
        }


        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project(1, "2021-10-01", "2022-12-01"));
        projectList.add(new Project(1, "2020-01-01", "2022-01-01"));
        projectList.add(new Project(1, "2019-09-01", "2022-10-01"));
        projectList.add(new Project(2, "2018-04-01", "2022-12-01"));
        projectList.add(new Project(3, "2019-10-01", "2022-08-01"));
        projectList.add(new Project(3, "2019-05-01", "2022-05-01"));
        projectList.add(new Project(4, "2021-02-01", "2022-07-01"));
        projectList.add(new Project(4, "2020-05-01", "2022-12-01"));
        projectList.add(new Project(5, "2020-04-01", "2022-11-01"));
        projectList.add(new Project(5, "2021-07-01", "2022-11-01"));
        ProjectDao projectDao = new ProjectDao(connection);
        for (Project project: projectList) {
            projectDao.insertProjects(project);
        }

        int[][] projectWorkerData = {
                {1, 1}, {2, 1}, {3, 3}, {3, 4},
                {4, 3}, {5, 4}, {5, 5}, {6, 5},
                {6, 6}, {7, 7}, {8, 8}, {9, 9},
                {10, 10}
        };
        ProjectWorkersDao projectWorkersDao = new ProjectWorkersDao(connection);
        for (int[] projectWorker : projectWorkerData) {
            projectWorkersDao.insertProjectWorker(projectWorker[0], projectWorker[1]);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


