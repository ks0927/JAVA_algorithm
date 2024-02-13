-- 코드를 입력하세요
SELECT TITLE, A.BOARD_ID, REPLY_ID, B.WRITER_ID, B.CONTENTS, date_format(B.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE

FROM USED_GOODS_BOARD A INNER JOIN USED_GOODS_REPLY B on A.BOARD_ID = B.BOARD_ID

WHERE A.CREATED_DATE like '2022-10%'

ORDER BY B.CREATED_DATE ASC, TITLE ASC;