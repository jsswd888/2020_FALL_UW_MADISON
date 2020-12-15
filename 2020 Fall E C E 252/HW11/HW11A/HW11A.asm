;HW 11A test code

;item 2: single instruction copy value from register to another 

    .ORIG	x0200

    LD R0, value1
    LD R1, value2

    ; data writes into R0
    ;ADD R0, R1, #0 

    ;LEA R0, value1
    ;AND R0, R1, #1

    ;LEA R0, value1
    ;NOT R0, R1
    ADD R0, R1, #0

value1  .FILL 2
value2  .FILL 3
        
    .END