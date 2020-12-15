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
	ST	R1,	Saturate_Sum_Arr_R1 	; context save
	ST  R2, Saturate_Sum_Arr_R2
	ST  R7, Saturate_Sum_Arr_R7

  ADD R1,	R0,	#0 								; Copy starting address for array to R1
	AND R2, R2,	#0 								; Clear R2

; R0 is used to store temp vals (only for loop), R2 stores sum of vals
Sat_Sum_Arr_Loop
	LDR	R0, R1,	#0
	BRz	Sat_Sum_Arr_Exit					; return if 0 found, else:
	JSR Saturate_Value
	ADD R2, R2, R0
	ADD R1, R1, #1 								; increment source address
	BR	Sat_Sum_Arr_Loop

Sat_Sum_Arr_Exit
 	ADD	R0, R2, #0								; copy the sum(R2) in R0

	LD 	R1,	Saturate_Sum_Arr_R1 	; context restore
	LD  R2, Saturate_Sum_Arr_R2
	LD  R7, Saturate_Sum_Arr_R7

	RET
	Saturate_Sum_Arr_R1	.BLKW	#1
	Saturate_Sum_Arr_R2 .BLKW #1
	Saturate_Sum_Arr_R7 .BLKW #1
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
	ST 	R1,	Saturate_Value_R1 		; context save

	ADD	R1, R0, #0
	BRn	Sat_Val_If_Negative				; branch to -ve val handling, else fall to +ve:

; if number is +ve:
Sat_Val_If_Positve
	LD	R1, Negative_50
	ADD	R1, R0, R1
	BRnz	Saturate_Value_Exit 		; exit if already in range, else:
	LD	R1, Positive_50
	ADD	R0, R1, #0					 			; copy upper limit val to satisfy range
	BR	Saturate_Value_Exit				; task done, exit

; if number is -ve:
Sat_Val_If_Negative
	LD	R1, Positive_50
	ADD	R1, R0, R1
	BRzp	Saturate_Value_Exit			; exit if already in range, else:
	LD	R1, Negative_50
	ADD	R0, R1, #0					 			; copy lower limit val to satisfy range

Saturate_Value_Exit
	LD 	R1, Saturate_Value_R1			; context restore

	RET
	Saturate_Value_R1	.BLKW #1
	Positive_50				.FILL	#50
	Negative_50				.FILL	#-50
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

 
