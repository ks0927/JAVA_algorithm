-- 코드를 작성해주세요
SELECT A.ITEM_ID, ITEM_NAME, RARITY

FROM ITEM_INFO A INNER JOIN ITEM_TREE B on A.ITEM_ID = B.ITEM_ID

WHERE PARENT_ITEM_ID in (
    SELECT A.ITEM_ID 
    FROM ITEM_INFO A INNER JOIN ITEM_TREE B on A.ITEM_ID = B.ITEM_ID
    WHERE RARITY = 'RARE')

ORDER BY A.ITEM_ID DESC;