# 文件描述符
文件描述符在linux操作系统中就是一个整数，例如：0-标准输入，1-标准输出，2-错误输出。

文件描述符是用来表示一个系统所持有的文件，程序打开一个文件就会有操作系统创建一个文件描述符，这是一种系统资源。

# 管道和重定向
重定向的类型：<:输入重定向，>:输出重定向，<<:累加输入重定向，>>:累加输出重定向，|：管道，2>:错误输出，1>标准输出，
2>&1：和并的标准输出和错误输出 2>必须写在一起，用来表示标准的错误输出

