# Java Foundation

## Basics
1. The minimum storage unit in a computer is a **byte**. A byte is composed of eight **bits**.
2. Every bite in the memory has a unique address, the address is used to locate the byte for storing and retrieving the data. Since the byte in the memory can be accessed in any order, the memory is also referred to as **random-access memory** (RAM). 
3. A Java program in a .java file would be compiled into a .class file (bytecode file). The .class file is executed by the **Java Virtual Machine**.
4. The bytecode is similar to machine instructions but is architecture neutral and can run on any platform that has a **Java Virtual Machine (JVM)**. 
5. ASCII code (128): a 7-bit encoding scheme for representing all uppercase and lowercase letters. 
6. Unicode: 16 bits or more, including ASCII code.
7. Casting between **char** and numeric types: 
    1. A **char** can be cast into any numeric type, and vice versa. When an integer is cast into a char, only its lower 16 bits of data are used, and the other part is ignored.
    2. When a floating-point value is cast into a char, the floating-point value is first cast into an **int**, which is then cast into a **char**.
    3. When a **char** is cast into a numeric type, the character's **Unicode** is cast into the specified numeric type.     

## Multiprogramming, Multithreading, and Multiprocessing
1. **Multiprogramming**: allows multiple programs to run simultaneously by sharing the same CPU. 
2. **Multithreading**: allows a single program to execute multiple tasks at the same time. 
3. **Multiprocessing** or **Parallel processing**: use two or more processors together to perform subtasks concurrently and then combine solutions of the subtasks to obtain a solution for the entire task. 

## Array
1. The **java.util.Arrays** class:
    1. Arrays.sort(arr);
    2. Arrays.fill(arr, 1);

