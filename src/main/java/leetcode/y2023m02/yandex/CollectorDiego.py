from bisect import bisect_left

if __name__ == '__main__':
    with open('input.txt') as file:
        data = file.readlines()
    t = int(data[0].replace('\n', ''))
    nStickers = set(map(int, data[1].replace('\n', '').split()))
    k = int(data[2].replace('\n', ''))
    nCollectors = list(map(int, data[3].replace('\n', '').split()))
    sortedNStickers = sorted(list(nStickers))
    ans = '\n'.join(str(bisect_left(sortedNStickers, i)) for i in nCollectors)
    with open('output.txt', 'w') as file:
        file.write(ans)
    # nStickers = {1, 30, 2, 29, 3, 28, 4, 27, 5, 26, 6, 25, 7, 24, 8, 23, 9, 22, 10, 21, 11, 20, 12, 19, 13, 18, 14, 17, 15, 16}
    # nCollectors = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31]
    # print_difference(nStickers, nCollectors)
