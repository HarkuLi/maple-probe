def main():
    lines = []

    with open('./handbook/Mob.txt', "r") as file_iter:
        line_num = 0
        for line in file_iter:
            line_num += 1

            handled_line = line.strip()
            if len(handled_line.split(' - ')) >= 3:
                handled_line = handled_line.rsplit(' -', 1)[0]

            parts = handled_line.strip().split(' - ', 1)
            if len(parts) < 2:
                raise Exception('Unexpected format: ' + line + '(line ' + str(line_num) + ')')

            lines.append({'id': parts[0].strip(), 'name': parts[1].strip()})

    with open("output.txt", "w") as file:
        file.write("{\n")
        for line in lines:
            file.write("    \"%s\": \"%s\",\n" % (line['id'], line['name']))
        file.write("}\n")

if __name__ == '__main__':
    main()
