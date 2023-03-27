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

type square struct {
	h   int
	idx int
}

func main() {
	s := NewStack[square]()

	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var k int
	for {
		fmt.Fscan(reader, &k)
		if k == 0 {
			break
		}

		var num int
		var result int64
		for i := 0; i < k; i++ {
			fmt.Fscan(reader, &num)

			idx := i
			for !s.IsEmpty() && s.Peek().h >= num {
				width := i - s.Peek().idx
				result = max(result, int64(width*s.Peek().h))
				idx = s.Peek().idx
				s.Pop()
			}

			s.Push(square{h: num, idx: idx})
		}

		for !s.IsEmpty() {
			result = max(result, int64((k-s.Peek().idx)*s.Peek().h))
			s.Pop()
		}

		fmt.Fprintln(writer, result)
	}

}

func max(a, b int64) int64 {
	if a > b {
		return a
	} else {
		return b
	}

}
