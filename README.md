# testFirst
我的第一个项目


tail -n 50000 info.log  查询后多少行

cat -n test.txt | grep 'zhendaxia'  根据关键字检索日志文件


--查子集
SELECT
dept_id
FROM
(
SELECT
t1.dept_id,
t1.dept_name,
IF
( find_in_set( parent_id, @pids ) > 0, @pids := concat( @pids, ',', dept_id ), 0 ) AS ischild
FROM
( SELECT dept_id, parent_id, dept_name FROM mer_dept t ORDER BY parent_id, dept_id ) t1,
( SELECT @pids := 1) t2
) t3
WHERE
ischild != 0



--查父级
SELECT T2.*
FROM (
SELECT
@r AS _id,
(SELECT @r := parent_id FROM mer_dept WHERE dept_id = _id) AS parent_id,
@l := @l + 1 AS lvl
FROM
(SELECT @r := 6, @l := 0) vars,
mer_dept h
WHERE @r <> 0) T1
JOIN mer_dept T2
ON T1._id = T2.dept_id and t2.dept_id != 6
ORDER BY T1.lvl DESC




