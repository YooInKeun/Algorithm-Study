SET @hour := -1;

SELECT (@hour := @hour + 1) AS hour, (SELECT count(*) FROM animal_outs WHERE hour(datetime) = @hour) AS count
FROM animal_outs
WHERE @hour < 23;
