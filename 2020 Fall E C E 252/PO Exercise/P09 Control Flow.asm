; Filename:     P09 Control Flow
; Author:       Shi Kaiwen
; Description:  

        .ORIG	x0200
START


ADD3
    ; ADD R0, R1, R2, return back into R3
    ADD R3, R0, R1
    ADD R3, R3, R2
    ST R3, R3

MAXIMUM
    ; negatie R0, compare whether R0 or R1 is bigger
    NOT R0, #0
    ADD R0, R0, #1
    ADD R2, R0, R1
    BRnp

MaxArray
    JSR	PCoffset11



DONE    BR START


        .END
