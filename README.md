# Encryption
An application that encrypts or decrypts a file or String using command line arguments. 

The syntax is :

```bash
java EncryptApp  -alg {shift|unicode} -mode {enc|dec} -key n -data "string data" -in filename -out outputfile
```

All the arguments are optional and the meanings of the options are:

**-alg shift|unicode** is the algorithm to use for encryption and decryption.

* “shift” means to shift the English letters using a rotational cipher. Other characters (not letters) are not modified.
* “unicode” means to shift all characters using the Unicode character sequence. See below (or hyperskill.org) for more explanation.
* If -alg is not specified, the default algorithm is “shift”.

**-mode** enc/dec program should perform encryption (“enc”) or decryption (“dec”). If -mode is not specified the default mode is “enc”.

**-key** n n is a number used as encryption key in the algorithm. If not specified, the default key is 0.

**-data** “string” specify a string to encrypt or decrypt. See -in, too.

**-in** filename name of input file containing text to encrypt or decrypt. If both -data and -in are given, then -data has precedence. If neither of these is given then assume that data is an empty string (as if -data "").

**-out** outputfile write the output to outputfile. If this option is not given then output to System.out.

## Example
Command :  ```java EncryptApp -mode enc -key 5 -data "Welcome to hyperskill!"```

Output  : ```Bjqhtrj yt mdujwxpnqq!```

Command :  ```java EncryptApp -mode dec -key 5 -data "Bjqhtrj yt mdujwxpnqq!"```

Output  : ```Welcome to hyperskill!```

Command :  ```java EncryptApp -mode enc -key 5 -data "Welcome to hyperskill!"  -alg unicode```

Output  : ```\jqhtrj%yt%m~ujwxpnqq&```

Command :  ```java EncryptApp -mode enc-key 12 -in secret.txt -out secret.enc```

Output : ```Completed!```

Encrypts file secret.txt and writes the output to secret.enc.

## Requirements
The application requires
* JavaSE13

* IDE (IntelliJ IDEA , Visual Studio Code)

## Installation
1. Clone this repository then go to the directory.

```bash 
git clone https://github.com/OOP2020/pa2-forfeen.git
```

```bash 
cd pa2-forfeen
```

2. Compile the EncryptApp.java

```bash
javac EncryptApp.java
```

3. Encrypts or Decrypts a file or String using command line arguments. (as Example)

```bash
java EncryptApp -mode enc -key 5 -data "Welcome to hyperskill!"
```

> Suggestion : If you can't input a string by using **" "** (Double Quote) , So you can use **' '** (Single Quote).

> For Example : java EncryptApp -mode enc -key 5 -data 'Welcome to hyperskill!'
