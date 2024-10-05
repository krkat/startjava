SELECT 'Вывод всей таблицы' AS Комментарий;
SELECT * FROM jaegers
ORDER BY model_name;

SELECT 'Вывод только не уничтоженных роботов' AS Комментарий;
SELECT * FROM jaegers
WHERE status != 'Destroyed'
ORDER BY model_name;

SELECT 'Вывод роботов серии Mark-1 и Mark-4' AS Комментарий;
SELECT * FROM jaegers
WHERE mark IN ('Mark-1', 'Mark-4')
ORDER BY model_name;

SELECT 'Только роботы серии не Mark-1 и не Mark-4 по убыванию mark' AS Комментарий;
SELECT * FROM jaegers
WHERE mark NOT IN ('Mark-1', 'Mark-4')
ORDER BY mark DESC;

SELECT 'Вывод информации о самых старых роботах' AS Комментарий;
SELECT * FROM jaegers
WHERE launch = (SELECT MIN(launch) FROM jaegers)
ORDER BY model_name;

SELECT 'Вывод информации о тех роботов, которые уничтожили больше всех kaiju' AS Комментарий;
SELECT model_name, mark, launch, kaiju_kill FROM jaegers
WHERE kaiju_kill = (SELECT MAX(kaiju_kill) FROM jaegers)
ORDER BY model_name;

SELECT 'Вывод среднего веса, округленного до трех знаков после запятой' AS Комментарий;
SELECT ROUND(AVG(weight), 3) AS Average_weight FROM jaegers;

SELECT 'Увеличение количества kaiju_kill у неразрушенных роботов' AS Комментарий;
UPDATE jaegers
SET kaiju_kill = kaiju_kill + 1
WHERE status != 'Destroyed';
SELECT * FROM jaegers;

SELECT 'Удаление уничтоженных роботов' AS Комментарий;
DELETE FROM jaegers
WHERE status = 'Destroyed';
SELECT * FROM jaegers;