select a.id as "id" from Weather a, Weather b
where 
DATEDIFF(a.recordDate,b.recordDate)=1 AND a.temperature>b.temperature;


// s2
SELECT
    weather.id AS 'Id'
FROM
    weather
        JOIN
    weather w ON DATEDIFF(weather.recordDate, w.recordDate) = 1
        AND weather.Temperature > w.Temperature
;
