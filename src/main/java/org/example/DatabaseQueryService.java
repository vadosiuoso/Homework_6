package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class DatabaseQueryService {
    private static final Connection CONNECTION = Database.getInstance().getConnection();
    private Statement statement;
    public static void main(String[] args) throws SQLException {


        List<MaxSalaryWorker> maxSalaryWorkers = findMaxSalaryWorker();
        for (MaxSalaryWorker worker : maxSalaryWorkers){
            System.out.println(worker);
        }

        List<MaxProjectCountClient> maxProjectCountClientList = findMaxProjectsClient();
        for (MaxProjectCountClient client: maxProjectCountClientList) {
            System.out.println(client);
        }

        List<LongestProject> longestProjectList = findLongestProject();
        for (LongestProject project : longestProjectList) {
            System.out.println(project);
        }

        List<YoungestOldestWorkers> youngestEldestWorkersList = findYoungestOldestWorkers();
        for (YoungestOldestWorkers workers: youngestEldestWorkersList) {
            System.out.println(workers);
        }

        List<ProjectPrices> projectPricesList = countProjectPrices();
        for (ProjectPrices prices: projectPricesList) {
            System.out.println(prices);
        }
        CONNECTION.close();
    }

    public static List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try(Statement statement = CONNECTION.createStatement()){
            String query = ReadSQL.readSqlFile("sql/find_max_projects_client.sql");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int projectCount = resultSet.getInt(2);
                result.add(new MaxProjectCountClient(name, projectCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        try (Statement statement = CONNECTION.createStatement()) {
            String query = ReadSQL.readSqlFile("sql/find_max_salary_worker.sql");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int salary = resultSet.getInt(2);
                result.add(new MaxSalaryWorker(name, salary));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static List<LongestProject> findLongestProject(){
        List<LongestProject> result = new ArrayList<>();
        try (Statement statement = CONNECTION.createStatement()) {
            String query = ReadSQL.readSqlFile("sql/find_longest_project.sql");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                result.add(new LongestProject(id));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static List<YoungestOldestWorkers> findYoungestOldestWorkers(){
        List<YoungestOldestWorkers> result = new ArrayList<>();
        try (Statement statement = CONNECTION.createStatement()) {
            String query = ReadSQL.readSqlFile("sql/find_youngest_eldest_workers.sql");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String youngestOldest = resultSet.getString(1);
                Date birthday = resultSet.getDate("Birthday");
                result.add(new YoungestOldestWorkers(youngestOldest, birthday));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static List<ProjectPrices> countProjectPrices(){
        List<ProjectPrices> result = new ArrayList<>();
        try(Statement statement = CONNECTION.createStatement()){
            String query = ReadSQL.readSqlFile("sql/print_project_prices.sql");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int projectId = resultSet.getInt(1);
                int price = resultSet.getInt(2);
                result.add(new ProjectPrices(projectId, price));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
