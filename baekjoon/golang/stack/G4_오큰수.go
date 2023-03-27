package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Stack[T any] struct {
	data []T
	size int
}

func NewStack[T any]() *Stack[T] {
	return &Stack[T]{
		data: make([]T, 10000000),
		size: 0,
	}
}

func (s *Stack[T]) Push(d T) {
	s.data[s.size] = d
	s.size++
}

func (s *Stack[T]) Pop() T {
	if s.IsEmpty() {
		return *new(T)
	} else {
		s.size--
		return s.data[s.size]
	}
}

func (s *Stack[T]) IsEmpty() bool {
	return s.size == 0
}

func (s *Stack[T]) Peek() T {
	if !s.IsEmpty() {
		return s.data[s.size-1]
	}
	return *new(T)
}

type rNum struct {
	num int
	idx int
}

func main() {
	s := NewStack[rNum]()

	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var k int
	fmt.Fscan(reader, &k)
	resultArray := make([]string, k)

	var num int
	for i := 0; i < k; i++ {
		fmt.Fscan(reader, &num)

		for !s.IsEmpty() && s.Peek().num < num {
			tmp := s.Pop()
			resultArray[tmp.idx] = strconv.Itoa(num)
		}
		s.Push(rNum{num: num, idx: i})
	}

	for !s.IsEmpty() {
		resultArray[s.Pop().idx] = strconv.Itoa(-1)
	}

	fmt.Fprint(writer, strings.Join(resultArray, " "))
}
