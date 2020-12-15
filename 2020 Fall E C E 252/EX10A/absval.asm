; This program replaces the value in R0 with its absolute value.
;
; It does NOT modify any other registers!
;
        .ORIG x0200
START
        ADD R0, R0, #0  ; copy R0 to itself to set the condition codes based on R0
        BRzp DONE	    ; if R0 is NON-NEGATIVE, skip the negation (already correct)
        NOT R0, R0	    ; R0 is negative, so negate it
        ADD R0, R0, #1

DONE    BR START
   	
	.END