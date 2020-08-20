SELECT ai.animal_id as ANIMAL_ID, ai.animal_type as ANIMAL_TYPE, ai.name as NAME
FROM animal_ins ai 
JOIN animal_outs ao ON ai.animal_id = ao.animal_id
AND ai.sex_upon_intake LIKE '%Intact%'
AND (ao.sex_upon_outcome LIKE '%Spayed%' OR ao.sex_upon_outcome LIKE '%Neutered%');
