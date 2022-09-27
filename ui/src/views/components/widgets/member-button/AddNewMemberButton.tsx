import { Dispatch, SetStateAction } from "react";

import { Button } from "reactstrap";

import { Employee } from "@/types/domain/employee-model.type";
import { Group, GroupMembers } from "@/types/domain/group-model.type";

interface Props {
  selectedFlatRows?: Employee[];
  toggleAllRowsSelected?: (value?: boolean | undefined) => void;
  setSelectedMembers: Dispatch<SetStateAction<GroupMembers[]>>;
  setGroupUi: Dispatch<SetStateAction<Group>>;
  groupUi: Group;
}

export const AddNewMemberButton = ({
  selectedFlatRows = [],
  toggleAllRowsSelected,
  setSelectedMembers,
  setGroupUi,
  groupUi,
}: Props) => {
  const onMemberAdd = () => {
    const memberIds = selectedFlatRows.map(careMember => careMember.id);

    const groupMembers: GroupMembers = { members: selectedFlatRows, memberIds: memberIds };

    setGroupUi({
      ...groupUi,
      members: groupMembers.members,
      memberIds: groupMembers.memberIds,
    });

    setSelectedMembers([groupMembers]);

    if (toggleAllRowsSelected) {
      toggleAllRowsSelected();
    }
  };

  return (
    <Button color="success" onClick={onMemberAdd} disabled={selectedFlatRows.length === 0}>
      Add Members To Group
    </Button>
  );
};
