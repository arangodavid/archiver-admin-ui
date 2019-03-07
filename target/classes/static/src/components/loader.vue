<template>
    <icon icon="spinner" pulse class="slds-icon cmp-loader_spinner" />
</template>

<script>
    import Icons from '../core/icons';
    import {faSpinner} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faSpinner);

    export default {}
</script>

<style scoped>
    .cmp-loader_spinner {
        fill: #e71c50;
    }
</style>
