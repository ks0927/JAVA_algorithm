SELECT se.SCORE, se.EMP_NO , he.EMP_NAME, he.POSITION , he.EMAIL
FROM HR_EMPLOYEES he LEFT JOIN (
                                SELECT EMP_NO , SUM(SCORE) AS SCORE
                                FROM HR_GRADE
                                GROUP BY EMP_NO
                                    ) se ON he.EMP_NO = se.EMP_NO
ORDER BY SCORE desc
LIMIT 1