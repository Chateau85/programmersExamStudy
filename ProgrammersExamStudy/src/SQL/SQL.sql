-- https://programmers.co.kr/learn/courses/30/lessons/59034
SELECT ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC

-- https://programmers.co.kr/learn/courses/30/lessons/59035
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC

-- https://programmers.co.kr/learn/courses/30/lessons/59036
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION LIKE 'Sick'

-- https://programmers.co.kr/learn/courses/30/lessons/59037
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION NOT LIKE 'Aged'

-- https://programmers.co.kr/learn/courses/30/lessons/59403
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS

-- https://programmers.co.kr/learn/courses/30/lessons/59404
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME ASC, DATETIME DESC

-- https://programmers.co.kr/learn/courses/30/lessons/59405
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME ASC
LIMIT 1

-- https://programmers.co.kr/learn/courses/30/lessons/59415
SELECT MAX(DATETIME) AS 시간
FROM ANIMAL_INS

-- https://programmers.co.kr/learn/courses/30/lessons/59038
SELECT MIN(DATETIME) AS 시간
FROM ANIMAL_INS

-- https://programmers.co.kr/learn/courses/30/lessons/59406
SELECT COUNT(*)
FROM ANIMAL_INS

-- https://programmers.co.kr/learn/courses/30/lessons/59408
SELECT COUNT(*) 
FROM(
	SELECT NAME, COUNT(*) 
	FROM ANIMAL_INS 
	GROUP BY NAME HAVING NAME IS NOT NULL
	) AS NAME_TABLE

-- https://programmers.co.kr/learn/courses/30/lessons/59040
SELECT ANIMAL_TYPE, COUNT(*)
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE

-- https://programmers.co.kr/learn/courses/30/lessons/59041
SELECT NAME, COUNT(*) AS CCNT
FROM ANIMAL_INS
GROUP BY NAME
HAVING COUNT(NAME) >= 2

-- https://programmers.co.kr/learn/courses/30/lessons/59412
SELECT EXTRACT(HOUR FROM DATETIME) AS HOUR, COUNT(*)
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR >= 9 AND HOUR <= 19
ORDER BY HOUR

-- https://programmers.co.kr/learn/courses/30/lessons/59413
SET @hour := -1;

SELECT 
    (@hour := @hour + 1) AS 'HOUR',
    (SELECT count(*) FROM ANIMAL_OUTS WHERE hour(datetime) = @hour) AS 'COUNT'
FROM
    ANIMAL_OUTS
WHERE
    @hour < 23;

-- https://programmers.co.kr/learn/courses/30/lessons/59039
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL

-- https://programmers.co.kr/learn/courses/30/lessons/59407
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID ASC

-- https://programmers.co.kr/learn/courses/30/lessons/59410
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS

-- https://programmers.co.kr/learn/courses/30/lessons/59042
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_OUTS A LEFT JOIN ANIMAL_INS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.ANIMAL_ID

-- https://programmers.co.kr/learn/courses/30/lessons/59043
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS A LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.DATETIME > B.DATETIME
ORDER BY A.DATETIME

-- https://programmers.co.kr/learn/courses/30/lessons/59044
SELECT A.NAME, A.DATETIME
FROM ANIMAL_INS A LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.DATETIME LIMIT 3

-- https://programmers.co.kr/learn/courses/30/lessons/59045
SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_OUTS A JOIN ANIMAL_INS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.SEX_UPON_INTAKE LIKE 'Intact%'
AND (A.SEX_UPON_OUTCOME LIKE 'Spayed%' OR A.SEX_UPON_OUTCOME LIKE 'Neutered%')

-- https://programmers.co.kr/learn/courses/30/lessons/59046
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY ANIMAL_ID

-- https://programmers.co.kr/learn/courses/30/lessons/59047
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME LIKE '%el%'
AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME

-- https://programmers.co.kr/learn/courses/30/lessons/59409
SELECT ANIMAL_ID, NAME, CASE WHEN SEX_UPON_INTAKE LIKE '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%' THEN "O" ELSE "X" END AS "중성화"
FROM ANIMAL_INS

-- https://programmers.co.kr/learn/courses/30/lessons/59411
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS A, ANIMAL_OUTS B
WHERE A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY B.DATETIME - A.DATETIME DESC
LIMIT 2

-- https://programmers.co.kr/learn/courses/30/lessons/59414
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS "날짜"
FROM ANIMAL_INS