package main

import (
	"bufio"
	"fmt"
	"os"
)

type Stack struct {
	data []int
	size int
}

func NewStack() *Stack {
	return &Stack{
		data: make([]int, 100000),
		size: 0,
	}
}

func (s *Stack) Push(d int) {
	s.data[s.size] = d
	s.size++
}

func (s *Stack) Pop() int {
	if s.IsEmpty() {
		return -1
	} else {
		s.size--
		return s.data[s.size]
	}
}

func (s *Stack) IsEmpty() bool {
	return s.size == 0
}

func main() {
	s := NewStack()

	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var k int

	fmt.Fscan(reader, &k)
	var num int
	for i := 0; i < k; i++ {
		fmt.Fscan(reader, &num)

		if num != 0 {
			s.Push(num)
		} else {
			s.Pop()
		}
	}

	var result int
	for !s.IsEmpty() {
		result += s.Pop()
	}

	fmt.Fprint(writer, result)
}
