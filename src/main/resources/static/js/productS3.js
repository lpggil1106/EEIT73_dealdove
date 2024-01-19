import {} from "https://cdn.jsdelivr.net/npm/aws-sdk@2.1128.0/dist/aws-sdk.min.js";
const s3 = new AWS.S3({
    accessKeyId: 'AKIARQLKGSKVD35I62FW',
    secretAccessKey: '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'
});

export {s3};