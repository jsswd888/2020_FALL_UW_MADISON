; Filename:    strlen.asm
; Subroutine: STRLEN
; Description: Finds length of an ASCIIZ string
; Assumes: R1 - string address
; Returns: R2 - length of the string

;return length of the string

        .orig x0200

START   
	LEA	R1, S1
	JSR	STRLEN
	LEA	R1, S6
	JSR	STRLEN
	LEA	R1, S2
	JSR	STRLEN
	LEA	R1, S5
	JSR	STRLEN
	LEA	R1, S3
	JSR	STRLEN
	LEA	R1, S4
	JSR	STRLEN
	LEA	R1, S7
	JSR 	STRLEN
		
	BR	START	; loop forever

S1	.STRINGZ	"Ciao!"
S2	.STRINGZ	"Hi!"
S3	.STRINGZ	"Salve!"
S4	.STRINGZ	"Hello!"
S5	.STRINGZ	"Gelato!"
S6	.STRINGZ	""
S7	.STRINGZ	"Italiano"

; Subroutine:  STRLEN
; Description: Finds length of ASCIIZ string
; Assumes:     R1 = string address
; Returns:     R2 = length of the string 
STRLEN
	ST	R0, STRLEN_R0	; context save
    ST  R1, STRLEN_R1   ; context save ADDED

	AND R2, R2, #0	; ADDED initialize String len to 0

STRLEN_LOOP
	LDR	R0, R1, #0	; get current character
	BRz	STRLEN_EXIT	; at null terminator?
	
	ADD R2, R2, #1	; ADDED increment the string count//count how many
					; numbers of the character is not null

	ADD	R1, R1, #1	; increment string pointer (address)
	BR	STRLEN_LOOP

STRLEN_EXIT
	LD	R0, STRLEN_R0	; context restore
    LD  R1, STRLEN_R1   ; ADDED 
    
	;NOT R3, R3
    ;ADD R3, R3, #1
    ;ADD R2, R3, #1
	RET

STRLEN_R0	.BLKW	1

STRLEN_R1   .BLKW	1	; ADDED
		
	.end