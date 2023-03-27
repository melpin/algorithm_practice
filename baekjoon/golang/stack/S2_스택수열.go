package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
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

func (s *Stack) Peek() int {
	if !s.IsEmpty() {
		return s.data[s.size-1]
	}
	return 0
}

func main() {
	s := NewStack()

	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var k int

	stackNum := 1

	fmt.Fscan(reader, &k)
	var resultArray []string

	var num int
	for i := 0; i < k; i++ {
		fmt.Fscan(reader, &num)
		for stackNum <= num {
			s.Push(stackNum)
			resultArray = append(resultArray, "+")
			stackNum++
		}
		if s.Peek() != num {
			fmt.Fprint(writer, "NO\n")
			return
		}
		s.Pop()
		resultArray = append(resultArray, "-")
	}

	fmt.Fprint(writer, strings.Join(resultArray, "\n"))
}
