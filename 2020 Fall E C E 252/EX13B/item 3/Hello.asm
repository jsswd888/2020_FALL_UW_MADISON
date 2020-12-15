	.orig x3000
;
START   
			; get address of S1       
	PUTS		; write to console
	HALT
; 
S1	.STRINGZ	"Hello, world!\n"
	.end