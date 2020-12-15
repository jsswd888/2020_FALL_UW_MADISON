        .orig x3000

START   
	; first show initial strings before modification
	
        ; print all three strings on one line
	LEA	R0, LF	; print newline
	PUTS
	LEA	R0, S1	; print the strings
	PUTS
	LEA	R0, S2
	PUTS
	LEA	R0, S3
	PUTS
	LEA	R0, LF	; print newline
	PUTS

TEST1	; first test
	LEA	R1, S2
	LEA	R2, S3
	JSR	STRCAT	; append S2 to S3
			; after subroutine returns, S3 should be "horse+bird+"

        ; print all three strings on one line
	LEA	R0, S1	; print the strings
	PUTS
	LEA	R0, S2
	PUTS
	LEA	R0, S3
	PUTS
	LEA	R0, LF	; print newline
	PUTS

TEST2	; second test
	LEA	R1, S1
	LEA	R2, S3
	JSR	STRCAT	; append S1 to S3
			; after subroutine returns, S3 should be "horse+bird+cat+"

        ; print all three strings on one line
	LEA	R0, S1	; print the strings
	PUTS
	LEA	R0, S2
	PUTS
	LEA	R0, S3
	PUTS
	LEA	R0, LF	; print newline
	PUTS

	HALT		; end program

; test data
LF	.STRINGZ	"\n" 
S1	.STRINGZ	"cat+"
S2	.STRINGZ	"bird+"
S3	.STRINGZ	"horse+"
	.BLKW	16	; extra space



; STRCPY
; Copy source string to destination
; Assumes: R1 - source string address
;          R2 - destination address
; Returns: Nothing

; -- put your STRCPY subroutine and its data below here --
STRCPY
	ST R1, STRCPY_R1		 ; context save
    ST R2, STRCPY_R2         
    ST R3, STRCPY_R3         

STRCPY_LOOP
    LDR R3, R1, #0          ; get current character
    STR R3, R2, #0
    BRz STRCPY_EXIT         ; is it at null-character?

              
    ADD R1, R1, #1          ; increment source addr
    ADD R2, R2, #1          ; increment dest addr
    BR STRCPY_LOOP

STRCPY_EXIT
	LD R1, STRCPY_R1        ; context save
    LD R2, STRCPY_R2        ; context restore
    LD R3, STRCPY_R3        
	RET

STRCPY_R1   .BLKW	1
STRCPY_R2   .BLKW	1
STRCPY_R3   .BLKW	1
; -- put your STRCPY subroutine and its data above here --


; ONLY TURN IN YOUR STRCAT SUBROUTINE CODE AND ITS DATA.
; DO NOT TURN IN THE CALLER CODE AND DATA ABOVE

; DO NOT MODIFY ANYTHING ABOVE HERE *EXCEPT* FOR COPYING
; IN YOUR **TESTED AND WORKING** STRCPY SUBROUTINE

; STRCAT
; Append source string to destination
; Assumes: R1 - source string address
;          R2 - destination address
; Returns: Nothing
STRCAT
	ST R1, STRCAT_R1        ; context save
    ST R2, STRCAT_R2        

STRCAT_LOOP
    LDR R3, R2, #0
    BRz CALL_STRCPY         ; is it at null character?          
    ADD R2, R2, #1          ; increment destination pointer
    BR STRCAT_LOOP

CALL_STRCPY
    BR STRCPY

STRCAT_EXIT
	LD R1, STRCAT_R1		; context restore
	LD R2, STRCAT_R2

    RET

STRCAT_R1   .BLKW	1
STRCAT_R2   .BLKW	1

	.end
       