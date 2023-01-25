#!/usr/bin/env python

import os
from urllib import parse

HEADER="""
# 백준 & 프로그래머스 & SWEA 문제 풀이 목록
"""

def main():
    content = ""
    content += HEADER
    
    directories = []
    solveds = []

    for root, dirs, files in os.walk(".\\src\\main\\java"):
        dirs.sort()
        if root == '.\\src\\main\\java':
            for dir in ('main', 'java'):
                try:
                    dirs.remove(dir)
                except ValueError:
                    pass
            continue
        
        category = os.path.basename(root)
        directory = os.path.basename(os.path.dirname(root))

        if directory == 'java':
            continue
        if directory not in directories:
            if directory in ["baekjoon", "swexpertacademy","programmers"]:
                content += "## 📚 {}\n".format(directory)
            directories.append(directory)
        
        content += "### 🚀 {}\n".format(category)
        content += "| 문제번호 | 링크 |\n"
        content += "| ----- | ----- |\n"
        for file in files:
            print(file,solveds)
            if file not in solveds:
                content += "|{}|[링크]({})|\n".format(file.split('.')[0], parse.quote(os.path.join(root, file)))
                solveds.append(file)

    with open("README.md", "w",encoding='utf-8') as fd:
        fd.write(content)
        
if __name__ == "__main__":
    main()
