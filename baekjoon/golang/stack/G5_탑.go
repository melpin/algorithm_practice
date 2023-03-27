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

type tower struct {
	height int
	idx    int
}

func main() {
	s := NewStack[tower]()

	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var k int
	fmt.Fscan(reader, &k)

	var resultArray []string
	s.Push(tower{height: 100000001, idx: 0})

	var num int
	for i := 1; i <= k; i++ {
		fmt.Fscan(reader, &num)
		for s.Peek().height < num {
			s.Pop()
		}

		resultArray = append(resultArray, strconv.Itoa(s.Peek().idx))
		s.Push(tower{height: num, idx: i})
	}

	fmt.Fprint(writer, strings.Join(resultArray, " "))
}
