;******************************************************************************
; Filename:    hw11.asm
; Author:      Shi Kaiwen kshi42@wisc.edu
; Description: Test Code for Saturate_Sum_Array subroutine
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
    JSR Saturate_Value          ; get saturated value from Saturate_Value 
    BRz Saturate_sum_Exit       ; if it is zero, directly store 0 and return
    ADD R0, R0, #0              ; if != 0, sum R0 value up
    BR Saturate_Sum_Array
Saturate_Sum_Exit
    RET
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
    ; Assume num is positive initially; use R6 store temporary values
    LDR R0, R0, #0              ; Load R0 value
    STR R0, R6, #0              ; store R0 value to R6 for further use
    BRnz Is_Less_Than_Minus50   ; check value: if its non_positive
                                ; if less than -50, should saturate to -50
    
Is_Greater_Than_50
    ADD R6, R6, #-16        ; R6 = signed num - 50
    ADD R6, R6, #-16
    ADD R6, R6, #-16
    ADD R6, R6, #-2
    BRnz Saturate_Value_Exit ; This shows value is not greater than 50, directly send back

Saturate_to_50
    STR R0, R0, #31          ; set R0 to be 50
    ADD R0, R0, #15
    ADD R0, R0, #4
    BR Saturate_Value_Exit

Is_Less_Than_Minus50
    ADD R6, R6, #15        ; R6 = signed num + 50
    ADD R6, R6, #15
    ADD R6, R6, #15
    ADD R6, R6, #5
    BRp Saturate_Value_Exit ; This shows value is larger than -50, directly send back

Saturate_To_Minus50    
    STR R0, R0, #31           ; set R0 to be -50
    NOT R0, R0
    ADD R0, R0, #1         
    ADD R0, R0, #-19

Saturate_Value_Exit
    STR R0, R0, #0
    RET
	; YOUR CODE GOES ABOVE HERE

    LD

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

 
