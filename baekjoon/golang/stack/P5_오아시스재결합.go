package main

import (
	"bufio"
	"fmt"
	"os"
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

type oasis struct {
	h     int
	count int
}

func main() {
	s := NewStack[oasis]()

	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var k int
	fmt.Fscan(reader, &k)

	var result, num int
	for i := 0; i < k; i++ {
		fmt.Fscan(reader, &num)
		cnt := 1

		for !s.IsEmpty() && s.Peek().h <= num {
			result += s.Peek().count
			if s.Peek().h == num {
				cnt += s.Peek().count
			}
			s.Pop()
		}

		if !s.IsEmpty() {
			result++
		}
		s.Push(oasis{h: num, count: cnt})
	}

	fmt.Fprint(writer, result)
}
