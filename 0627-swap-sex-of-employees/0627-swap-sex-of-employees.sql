# Write your MySQL query statement below
Update salary
set sex=
CASE
WHEN sex='m' THEN 'f'
else 'm'
END