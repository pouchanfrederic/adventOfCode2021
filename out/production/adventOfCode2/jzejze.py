list = []

hauteur, distance = 0,0
with open('C:\\Users\\FRED\\Documents\\Développement\\adventOfCode2\\src\\data2.txt', 'r') as infile:

    fileline = infile.read().splitlines()
    for elmt in fileline:
        list.append(elmt.split(' '))

    for oui in list:
        match oui[0]:
            case 'forward':
                distance += int(oui[1])
                print(distance , int(oui[1]))
            case 'down':
                hauteur += int(oui[1])
            case 'up':
                hauteur -= int(oui[1])

print(distance)
print(hauteur)
print(distance*hauteur)