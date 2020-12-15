;******************************************************************************
; Filename:    hw11.asm
; Author:      Shi Kaiwen kshi42@wisc.edu
; Description: Test Code for Saturate_Sum_Array subroutine
; Partners: Anniruddh Kumar (Partner but submitting individually) 
;******************************************************************************
	.ORIG x0200
START    
	; set initial register values to make it easier to see if
	; they are changed by the subroutine
	LD R0, INITR0

	; run first test
	LEA R0, Test1
	JSR Saturate_Sum_Array
    ADD R1, R0, #0

	; run remaining tests
	; figure out what each call should return, and verify that it does

	LEA R0, Test2
	JSR Saturate_Sum_Array
    ADD R2, R0, #0

	LEA R0, Test3
	JSR Saturate_Sum_Array
    ADD R3, R0, #0

	LEA R0, Test4
	JSR Saturate_Sum_Array
    ADD R4, R0, #0

	LEA R0, Test5
	JSR Saturate_Sum_Array
    ADD R5, R0, #0

DONE BR DONE		; Loop forever

INITR0 .FILL 0
Test1  .FILL 0
Test2  .FILL -10
       .FILL 10
       .FILL 1
       .FILL -100
       .FILL 33
       .FILL 57
       .FILL -27 
       .FILL -41
       .FILL 545
       .FILL 0      ; // Saturate_Sum_Array Should return 16 (0x10)
       .FILL 1000
Test3  .FILL 20
       .FILL -25
       .FILL -72
       .FILL 7
       .FILL 33
       .FILL 99
       .FILL 0
       .FILL 2000
Test4  .FILL 2
       .FILL 60
       .FILL -16
       .FILL 12
       .FILL 0
       .FILL 3000
Test5  .FILL -2
       .FILL -55
       .FILL -200
       .FILL 0
       .FILL 4000

;******************************************************************************
; Subroutine:  Saturate_Sum_Array
; Description: Starting from the given first element of an array, sum the
;              saturated value of each value in the array.  The function should
;              return when it finds an array value of 0.  An array that is 
;              empty should return a value of 0.
;
; Assumes      R0 - starting address for array
; Returns      R0 - The sum of the absolute values. 
;******************************************************************************
Saturate_Sum_Array
	; YOUR CODE GOES BELOW HERE
    ; R5 store temporary sum, R1 store address
    ; since call Saturate_Value, need to save & restore R7  
    ; context save
    ST R7, RegClear_R7      
    ST R5, RegClear_R5
    ST R1, RegClear_R1

    AND R5, R5, #0          ; clear R5 for store sum
    ADD R1, R0, #0          ; R1 copy address from R0             

Saturate_Sum_Loop
    LDR R0, R1, #0          ; load value sequentially via R1 to R0
    BRz Saturate_Sum_Exit   ; if it is zero, directly send back
    JSR Saturate_Value      ; saturate the value
    ADD R5, R5, R0          ; store temporary sum into R5
    ADD R1, R1, #1          ; go to next address
    BR saturate_sum_loop
    
Saturate_Sum_Exit
    ADD R0, R5, #0          ; copy temporary sum store in R5 into R0
    ;context restore
    LD R7, RegClear_R7
    LD R5, RegClear_R5
    LD R1, RegClear_R1
    RET

RegClear_R1   .BLKW #1
RegClear_R5   .BLKW #1
RegClear_R7   .BLKW #1
    ; YOUR CODE GOES ABOVE HERE

;******************************************************************************
; Subroutine:  Saturate_Value
; Description: Given a number, the function returns saturated value between 
;              -50 and 50.  See information about staturation arithmatic below.
;
; Assumes      R0 - signed number
; Returns      R0 - absolute value of the number.
;******************************************************************************
Saturate_Value
	; YOUR CODE GOES BELOW HERE
    ST R2, RegClear_R2          ; context save
    LD R3, UPPER_LIMIT          ; R3 <-- 50
    LD R4, BOTTOM_LIMIT         ; R4 <-- -50
    ADD R2, R0, #0              ; Load value in R0 into R2
    BRp Positive_Num_Test       ; if positive, test in +_num_test
    
    ; below shows when it is non-positive
    ADD R2, R2, R3              ; R2 <-- R2 + 50
    BRzp Saturate_Value_Exit    ; if non-negative: > -50, DON'T Saturate
    ADD R0, R4, #0              ; saturate value to -50 if needed
    BR Saturate_Value_Exit      ; go to exit

; when number is positive
Positive_Num_Test
    ADD R2, R2, R4              ; R2 <-- R2 - 50
    BRnz Saturate_Value_Exit    ; non-positive: < 50, DON'T Saturate
    ADD R0, R3, #0              ; otherwise saturate to 50

Saturate_Value_Exit
    ;context restore: only R2 changed
    LD R2, RegClear_R2
    RET


UPPER_LIMIT     .FILL 50
BOTTOM_LIMIT    .FILL -50
RegClear_R2     .BLKW #1
	; YOUR CODE GOES ABOVE HERE

	.END

; Saturation arithmetic is a version of arithmetic in which all operations 
; such as addition and multiplication are limited to a fixed range between 
; a minimum and maximum value.

; If the result of an operation is greater than the maximum, it is set 
; ("clamped") to the maximum; if it is below the minimum, it is clamped to 
; the minimum.
;
; Input: 40     Returns: 40
; Input:  0     Returns:  0
; Input:-20     Returns:-20 
; Input:-54     Returns:-50 
; Input:100     Returns: 50 

 
