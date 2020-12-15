; Filename:    hw08.asm
; Author(s):   KAIWEN SHI
;              kshi42@wisc.edu
;
; Description: Performs various operations on values in
;              various memory locations


        .ORIG x0200
START
        LEA R5, data		; get pointer to data array

        ; YOUR CODE GOES BELOW HERE
LEA R0, A
LEA R1, B
LEA R2, C
LDR R0, R5, #3          ;A = data[3]
ADD R1, R0, -2          ;B = A - 2
LDR R2, R5, #0          ;C = data[0]
ADD R2, R1, R2          ;C = B + data[0]
LDR R3, R5, #2          ;R3 = data[2]
LDR R4, R5, #1          ;R4 = data[1]
ADD R4, R1, R3          ;R4 = B + data[2]
STR R4, R5, #1          ;change data[1]
        ; YOUR CODE GOES ABOVE HERE

        BR START

        ; program data

A       .FILL x1111
B       .FILL x2222
C       .FILL x3333

      ; Note: normally we would not comment an array like this,
      ; but we wanted to make it easy to see which element is which
data    .FILL #10	 ; data[0]
        .FILL #20	 ; data[1]
        .FILL #-15	 ; data[2]
        .FILL #1	 ; data[3]

	.END