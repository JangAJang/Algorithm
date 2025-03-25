// solution.rs

use std::{collections::btree_map::Range, intrinsics::mir::Len, vec};

use crate::list_node::ListNode; // ListNode를 사용하려면 import 해야 합니다.

pub struct Solution;

impl Solution {
    // 두 개의 정렬된 리스트를 병합하는 함수
    pub fn merge_two_lists(
        list1: Option<Box<ListNode>>,
        list2: Option<Box<ListNode>>,
    ) -> Option<Box<ListNode>> {
        // TODO : 전체를 벡터로 빼낸다. 
        // 벡터를 크기순서로 정렬한다. 
        // 벡터에서 next만 처리해준다. 

        let mut vec: Vec<i32> = Vec::new();

        while list1.is_some() {
            vec.push(list1.as_ref().unwrap().val);
        }

        while list2.is_some() {
            vec.push(list2.as_ref().unwrap().val);
        }

        vec.sort();
        
        let mut node_vec: Vec<ListNode> = vec.iter().map(|value| ListNode::new(*value)).collect();

        for i in 0..vec.len()-2 {
            node_vec[i].next = Some(Box::new(node_vec[i+1]));
        }

        return Some(Box::new(node_vec[0]));
    }
}


/*
Option : java의 Optional<>로 처리하는 방식. is_some, is_none의 방식으로 처리 가능
Box : 스택이 아닌 힙에 메모리 할당하는 방식. 메모리 효율화를 위해 사용
*/