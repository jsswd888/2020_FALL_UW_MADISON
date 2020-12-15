 ; Filename:    hw09.asm
; Author(s):   SHI KAIWEN
;              kshi42@wisc.edu
; Partner:     Anniruddh Kumar (Partner but submitting individually) 
;
; Description: Performs various operations on values in
;              various memory locations


        .ORIG x0200
START

    ; YOUR CODE GOES BELOW HERE
    
    LEA R0, VARS    ; pointer R0 to VARS Array
    LDR R1, R0, #0  ; load A into R1
    LDR R2, R0, #1  ; load B into R2

    ; negate B
    NOT R2, R2
    ADD R2, R2, #1

    ; A - B, compare which one bigger
    ; result of A - B write into R3
    ADD R3, R1, R2          
    BRnz INC_C_WITH_D

    ; When A > B
    ; compare A > 32 or not:
    ADD R1, R1, #-16
    ADD R1, R1, #-16
    BRnz INC_C_WITH_E

; When A > 32: store value into C from B
; here R3 is B 
INC_C_WITH_B    
    LDR R3, R0, #1
    STR R3, R0, #2   
    BR INC_D_WITH_A

; When A < 32: store value into C from E
; here R2 is C R3 is E
INC_C_WITH_E
    LDR R3, R0, #4
    STR R3, R0, #2         

; last step: store value into D from A
; here R1 is A; since we have deduct value from R1
; before, we need to reload again here
INC_D_WITH_A
    LDR R1, R0, #0
    STR R1, R0, #3
    BR DONE

; when A < B: store value into C from D
; Here R3 is D
INC_C_WITH_D
    LDR R3, R0, #3
    STR R3, R0, #2
    ; YOUR CODE GOES ABOVE HERE

DONE    BR DONE

VARS .FILL  10      ; A
     .FILL  20      ; B
     .FILL  0       ; C
     .FILL  10      ; D
     .FILL  5       ; E

	.END
