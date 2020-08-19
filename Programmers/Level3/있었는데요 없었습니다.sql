SELECT ai.animal_id AS animal_id, ai.name AS name FROM animal_ins ai 
JOIN animal_outs ao ON ai.animal_id = ao.animal_id
WHERE ai.datetime > ao.datetime
ORDER BY ai.datetime;
