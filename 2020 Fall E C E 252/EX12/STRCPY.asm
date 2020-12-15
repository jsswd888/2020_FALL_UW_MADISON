        .orig x3000

START   
	; first show initial strings before modification
	
        ; print all four strings on one line
	LEA	R0, LF	; print newline
	PUTS
	LEA	R0, S1	; print the strings
	PUTS
	LEA	R0, S2
	PUTS
	LEA	R0, S3
	PUTS
	LEA	R0, S4
	PUTS
	LEA	R0, LF	; print newline
	PUTS

TEST1	; first test
	LEA	R1, S1
	LEA	R2, S3
	JSR	STRCPY	; copy S1 to S3
                        ; after subroutine returns, S3 should be "cat+"

        ; print all four strings on one line
	LEA	R0, S1	; print the strings
	PUTS
	LEA	R0, S2
	PUTS
	LEA	R0, S3
	PUTS
	LEA	R0, S4
	PUTS
	LEA	R0, LF	; print newline
	PUTS

TEST2	; second test
	LEA	R1, S2
	LEA	R2, S3
	JSR	STRCPY	; copy S2 to S3
			; after subroutine returns, S3 should be "bird+"

        ; print all four strings on one line
	LEA	R0, S1	; print the strings
	PUTS
	LEA	R0, S2
	PUTS
	LEA	R0, S3
	PUTS
	LEA	R0, S4
	PUTS
	LEA	R0, LF	; print newline
	PUTS

TEST3	; third test
	LEA	R1, S4
	LEA	R2, S1
	JSR	STRCPY  ; copy S4 to S1
			; after subroutine returns, S1 should be "elephant+"
			; ...but "elephant+" is longer than "cat+"... 

        ; print all four strings on one line
	LEA	R0, S1	; print the strings
	PUTS
	LEA	R0, S2
	PUTS
	LEA	R0, S3
	PUTS
	LEA	R0, S4
	PUTS
	LEA	R0, LF	; print newline
	PUTS

	HALT		; end program

; test data
LF	.STRINGZ	"\n" 
S1	.STRINGZ	"cat+"
S2	.STRINGZ	"bird+"
S3	.STRINGZ	"horse+"
S4	.STRINGZ	"elephant+"
	.BLKW	16	; extra space


; ONLY TURN IN YOUR STRCPY SUBROUTINE CODE AND ITS DATA.
; DO NOT TURN IN THE CALLER CODE AND DATA ABOVE

; DO NOT MODIFY ANYTHING ABOVE HERE

; STRCPY
; Copy source string to destination
; Assumes: R1 - source string address
;          R2 - destination address
; Returns: Nothing
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

	.end
       