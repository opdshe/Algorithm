alp = ['b', 'B', 'd', 'D', 'e', 'E', 'f', 'F', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N',
       'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 'Sr', 's', 'S', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z',
       'Z']
nuc = ['a', 'A', 'C', 'c', 'G', 'g', 't', 'T']


def comp(seq):
    comp_dict = {'A': 'T', 'T': 'A', 'C': 'G', 'G': 'C'}
    seq_comp = ""
    for char in seq:
        seq_comp = seq_comp + comp_dict[char]
    return seq_comp


def rev(seq):
    seq_rev = "".join(reversed(seq))
    return seq_rev


def rev_comp(seq):
    tmp = comp(seq)
    return rev(tmp)


dna = input("Enter a DNA sequence: ")
is_nucleotide = True
for i in dna:
    if i in alp:
        print("뉴클레오 타이드 아님. error")
        is_nucleotide = False
        break

if is_nucleotide:
    print("뉴클레오타이드")
    # 와 됐다...여기서 부터 하면됨#스텝 3로 들어가기->대문자를 소문자로 바꾸기!

    dna = dna.upper()
    print(dna)

    new_str = ""
    for idx in range(len(dna) - 1, -1, -1):
        new_str += dna[idx]
    dna = new_str
    print(dna)

    # 여기서부터 다시 함

    cnvt = int(input("1(comp),2(rev),3(rev_comp):"))
    if (cnvt >= 1 and cnvt <= 3):
        if (cnvt == 1):
            rst = comp(dna)
        elif (cnvt == 2):
            rst = rev(dna)
        else:
            rst = rev_comp(dna)
        print(dna, "->", rst)
