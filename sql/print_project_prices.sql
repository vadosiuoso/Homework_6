SELECT project.ID AS "Name", (SUM(worker.SALARY) * DATEDIFF(MONTH, START_DATE, FINISH_DATE)) AS "Price" FROM PROJECT 
JOIN PROJECT_WORKER ON project.ID = project_worker.PROJECT_ID
JOIN worker ON worker.ID = project_worker.WORKER_ID
GROUP BY project.ID;
