	; Example program	 
.ORIG x0276	 
BEGIN	LD R2, VAL_A	
	 	LD R3, VAL_B	
	 	ADD R1, R2, R3	
	 	LEA R0, SPACE	
	 	STR R1, R0, #4	 
	 	BR BEGIN
DONE BR DONE	 
; Data for the program	 
SPACE	.BLKW 7	 
VAL_A	.FILL #9	 
GAP	.BLKW 3	 
VAL_B	.FILL #6	 
 	.END	 	