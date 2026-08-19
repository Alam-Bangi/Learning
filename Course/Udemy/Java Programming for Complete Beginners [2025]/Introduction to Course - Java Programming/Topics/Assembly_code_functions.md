8086 Assembly Language, here is the instruction list with instruction name, syntax, and purpose.

8086 Assembly Instructions

No.	Instruction	    Name	                    Purpose / Explanation	                            Example
1	MOV	            Move	                    Transfers data from source to destination	        MOV AX, BX
2	PUSH	        Push	                    Places data onto the stack	                        PUSH AX
3	POP	            Pop	                        Retrieves data from the stack	                    POP AX
4	XCHG	        Exchange	                Exchanges data between two operands	                XCHG AX, BX
5	IN	            Input	                    Reads data from an I/O port	                        IN AL, 60H
6	OUT	            Output	                    Sends data to an I/O port	                        OUT 60H, AL
7	LEA	            Load Effective Address	    Loads the effective memory address into register	LEA SI, ARRAY
8	ADD	            Add	                        Adds two operands	                                ADD AX, BX
9	ADC	            Add with Carry	            Adds operands along with carry flag	                ADC AX, BX
10	SUB	            Subtract	                Subtracts the source from destination	            SUB AX, BX
11	SBB	            Subtract with Borrow	    Subtracts with carry/borrow	                        SBB AX, BX
12	INC	            Increment	                Increases operand by 1	                            INC AX
13	DEC	            Decrement	                Decreases operand by 1	                            DEC AX
14	MUL	            Unsigned Multiply	        Performs unsigned multiplication	                MUL BL
15	IMUL	        Signed Multiply	            Performs signed multiplication	                    IMUL BL
16	DIV	            Unsigned Divide	            Performs unsigned division	                        DIV BL
17	IDIV	        Signed Divide	            Performs signed division	                        IDIV BL
18	CMP	            Compare	                    Compares two operands by subtraction	            CMP AX, BX
19	AND	            Logical AND	                Performs bitwise AND	                            AND AX, BX
20	OR	            Logical OR	                Performs bitwise OR	                                OR AX, BX
21	XOR	            Exclusive OR	            Performs bitwise XOR	                            XOR AX, BX
22	NOT	            Complement	                Inverts all bits	                                NOT AX
23	TEST	        Test	                    Performs AND without changing the operands	        TEST AX, BX
24	SHL	            Shift Left	                Shifts bits to the left	                            SHL AX, 1
25	SHR	            Shift Right	                Performs logical right shift	                    SHR AX, 1
26	SAL	            Shift Arithmetic Left	    Shifts bits left	                                SAL AX, 1
27	SAR	            Shift Arithmetic Right	    Performs arithmetic right shift	                    SAR AX, 1
28	ROL	            Rotate Left	                Rotates bits to the left	                        ROL AL, 1
29	ROR	            Rotate Right	            Rotates bits to the right	                        ROR AL, 1
30	RCL	            Rotate through Carry Left	Rotates bits left through carry flag	            RCL AL, 1
31	RCR	            Rotate through Carry Right	Rotates bits right through carry flag	            RCR AL, 1
32	JMP	            Jump	                    Unconditionally transfers control	                JMP NEXT
33	JE/JZ	        Jump Equal / Zero	        Jumps if zero flag is set	                        JE LABEL
34	JNE/JNZ	        Jump Not Equal / Not Zero	Jumps if zero flag is clear	                        JNE LABEL
35	JC	            Jump Carry	                Jumps if carry flag is set	                        JC LABEL
36	JNC	            Jump No Carry	            Jumps if carry flag is clear	                    JNC LABEL
37	JA	            Jump Above	                Jumps if unsigned value is above	                JA LABEL
38	JB	            Jump Below	                Jumps if unsigned value is below	                JB LABEL
39	JG	            Jump Greater	            Jumps if signed value is greater	                JG LABEL
40	JL	            Jump Less	                Jumps if signed value is less	                    JL LABEL
41	LOOP	        Loop	                    Repeats a block using CX as counter	                LOOP LABEL
42	CALL	        Call Procedure	            Calls a procedure/subroutine	                    CALL SUM
43	RET	            Return	                    Returns from a procedure	                        RET
44	INT	            Interrupt	                Generates a software interrupt	                    INT 21H
45	IRET	        Interrupt Return	        Returns from an interrupt service routine	        IRET
46	CLC	            Clear Carry	                Clears carry flag	                                CLC
47	STC	            Set Carry	                Sets carry flag	                                    STC
48	CLD	            Clear Direction	            Clears direction flag	                            CLD
49	STD	            Set Direction	            Sets direction flag	                                STD
50	NOP	            No Operation	            Performs no operation	                            NOP
51	HLT	            Halt	                    Stops processor execution	                        HLT

Main Categories

Category	                Important Instructions
Data Transfer	            MOV, PUSH, POP, XCHG, LEA, IN, OUT
Arithmetic	                ADD, ADC, SUB, SBB, INC, DEC, MUL, IMUL, DIV, IDIV
Logical	                    AND, OR, XOR, NOT, TEST
Shift & Rotate	            SHL, SHR, SAL, SAR, ROL, ROR, RCL, RCR
Branch / Control Transfer	JMP, JE, JNE, JC, JNC, JA, JB, JG, JL, LOOP
Procedure	                CALL, RET
Interrupt	                INT, IRET
Flag Control	            CLC, STC, CLD, STD
Processor Control	        NOP, HLT

